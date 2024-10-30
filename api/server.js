import express from 'express';
import cors from 'cors';
import { sequelize } from './db/connection.js';
import { ENV } from './utils/env.js';

import EmailRouter from './routes/emails-routes.js';
import UserRouter from './routes/users-routes.js';
export class Server {

  constructor() {

    this.app = express();
    this.port = ENV.PORT || 3000;

    this.paths = {
      emails: '/api/emails',
      users: '/api/users',
    }

    this.middlewares();

    this.routes();

    this.initializeDatabase();
  }

  middlewares() {
    this.app.use(express.json());
    this.app.use(cors());
  }

  routes() {
    this.app.use(this.paths.emails, EmailRouter);
    this.app.use(this.paths.users, UserRouter);
  }

  async initializeDatabase() {
    try {
      await sequelize.authenticate();
      console.log('Conexion a la base de datos exitosa');
    } catch (error) {
      console.log('Falló la conexion a la base de datos');
    }
  }

  listen() {
    this.app.listen(this.port, () => {
      console.log(`Servidor corriendo en el puerto ${this.port}`);
    })
  }

}