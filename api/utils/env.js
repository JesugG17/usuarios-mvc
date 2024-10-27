import dotenv from 'dotenv';
dotenv.config();

export const ENV = {
  DATABASE_URL: process.env.DATABASE_URL,
  CLIENT_ID: process.env.CLIENT_ID,
  CLIENT_SECRET: process.env.CLIENT_SECRET,
  REFRESH_TOKEN: process.env.REFRESH_TOKEN
};