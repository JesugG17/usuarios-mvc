import { DataTypes } from "sequelize";
import { sequelize } from "../db/connection.js";

export const Token = sequelize.define('token', {
  id: {
    type: DataTypes.INTEGER,
    primaryKey: true,
    autoIncrement: true
  },
  token: {
    type: DataTypes.STRING,
    allowNull: false
  },
  usuario: {
    type: DataTypes.STRING,
    allowNull: false
  },
  fecha_creado: {
    type: DataTypes.TIME,
    allowNull: false
  },
  usado: {
    type: DataTypes.BOOLEAN,
    allowNull: false,
    defaultValue: false
  }
}, { timestamps: false });