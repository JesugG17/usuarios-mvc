import { DataTypes } from "sequelize";
import { sequelize } from "../db/connection.js";

export const User = sequelize.define('usuario', {
  correo: {
    type: DataTypes.STRING,
    primaryKey: true
  },
  nip: {
    type: DataTypes.STRING,
    allowNull: false
  },
  nombre: {
    type: DataTypes.STRING,
    allowNull: false
  },
  activo: {
    type: DataTypes.BOOLEAN
  },
  verificado: {
    type: DataTypes.BOOLEAN
  },
  num_intentos: {
    type: DataTypes.INTEGER
  },
  fecha_bloqueado: {
    type: DataTypes.DATE
  }
}, { timestamps: false });