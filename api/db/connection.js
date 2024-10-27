import { Sequelize } from "sequelize";
import { ENV } from "../utils/env.js";

export const sequelize = new Sequelize(ENV.DATABASE_URL, {
  timezone: '+00:00'
});