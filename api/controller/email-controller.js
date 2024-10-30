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

}