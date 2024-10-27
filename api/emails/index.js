import nodemailer from 'nodemailer';
import { google } from 'googleapis';
import { ENV } from '../utils/env.js';

const getAccessToken = async() => {
  const OAuth2 = google.auth.OAuth2;
  const oauth2Client = new OAuth2(ENV.CLIENT_ID, ENV.CLIENT_SECRET, 'https://developers.google.com/oauthplayground');

  oauth2Client.setCredentials({
    refresh_token: ENV.REFRESH_TOKEN
  });

  const tokens = await oauth2Client.refreshAccessToken();
  const accessToken = tokens.credentials.access_token;

  return accessToken;
}

const getSettings = async() => {
  const settings = {
    service: 'gmail',
    auth: {
      type: 'OAuth2',
      user: 'companyverifier17@gmail.com',
      clientId: ENV.CLIENT_ID,
      clientSecret: ENV.CLIENT_SECRET,
      refreshToken: ENV.REFRESH_TOKEN,
      accessToken: await getAccessToken() 
    }
  }

  return settings;
}

export const sendEmail = ({ email, token }) => {
  return new Promise(async(resolve) => {
    const settings = await getSettings();
    const transporter = nodemailer.createTransport(settings);

    const config = {
      from: 'companyverifier17@gmail.com',
      to: email,
      subject: 'Codigo de verificación',
      html: `
        <span style="font-size: 16px;">Usa el siguiente token en tu aplicacion, tiene una duracion de 15 minutos</span>
        <div style="background-color: gray; border: 1px solid black; padding: 1px 11px; border-radius: 5px, width: 100px; margin-top: 10px;">
          <h1>${token.toUpperCase()}</h1>
        </div>
      `
    };

    transporter.sendMail(config, (err, info) => {
      console.log(err)
      if (err) {
        resolve({ ok: false });
      } else {
        resolve({ ok: true });
      }
    });
  });
}