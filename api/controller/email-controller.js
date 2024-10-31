import { sendEmail } from "../emails/index.js";
import { Token } from "../models/token-model.js";
import { User } from "../models/user-mode.js";
import tokens from '../utils/tokens.js';


export class EmailController {

  static async sendEmailToken(req, res) {
    const { email } = req.body;

    if (!email) {
      return res.status(400).json({
        ok: false,
        message: 'Debe de proveer un email'
      });
    }

    const token = tokens.getToken();

    console.log({ email, token });

    const response = await sendEmail({ email, token });

    if (!response.ok) {
      return res.json({
        ok: false,
        message: 'Algo salio mal al enviar el correo.'
      });
    }

    const newToken = new Token({
      token,
      usuario: email,
      fecha_creado: new Date(),
      usado: false
    });

    await newToken.save();

    res.json({
      ok: true,
      message: 'Correo enviado exitosamente, checa tu bandeja de entrada.'
    });
  }

  static async verifyToken(req, res) {
    const { token, email } = req.body;

    if (!token) {
      return res.status(400).json({
        ok: false,
        message: 'Necesita proveer un token'
      });
    }

    const lastUserToken = await Token.findOne({
      where: {
        usuario: email,
        usado: false
      },
      order: [
        ['fecha_creado', 'DESC']
      ],
      limit: 1
    });
    console.log({ lastUserToken })
    if (!lastUserToken) {
      return res.status(400).json({
        ok: false,
        message: 'No existe un token para ese usuario'
      });
    }

    const FIFTEEN_MINUTES = 1000 * 60 * 15;
    const currentDate = new Date();
    const lastUserTokenDate = new Date(lastUserToken.fecha_creado);
    const tokenDifference = currentDate.getTime() - lastUserTokenDate.getTime();

    if (tokenDifference > FIFTEEN_MINUTES) {
      return res.status(401).json({
        ok: false,
        message: 'Su token ha expirado'
      });
    }

    if (token.toLowerCase() !== lastUserToken.token.toLowerCase()) {
      return res.status(400).json({
        ok: false,
        message: 'Token invalido'
      });
    }

    await Token.update(
      { usado: true },
      {
        where: {
          id: lastUserToken.id
        }
      }
    );

    res.json({
      ok: true,
      message: 'Token verificado exitosamente'
    });
  }

}