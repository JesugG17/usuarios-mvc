import { Token } from "../../models/token-model.js";

export const verifyToken = async(req, res, next) => {
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

    next();
}