import { User } from "../models/user-mode.js";


export class UserController {

  static async resetSession(req, res) {
    const { email } = req.body;

    await User.update(
      { activo: false },
      {
        where: {
          correo: email 
        }
      }
    );

    res.json({
      ok: true,
      message: 'Sesión restaurada exitosamente'
    });
  }

  static async verifyUser(req, res) {
    const { email } = req.body;

    await User.update(
      { verificado: true },
      {
        where: {
          correo: email
        }
      }
    );

    res.json({
      ok: true,
      message: 'Correo verificado exitosamente'
    });
  }
}