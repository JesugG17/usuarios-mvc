import { Router } from 'express';
import { EmailController } from '../controller/email-controller.js';

const router = Router();

router.post('/send-token', EmailController.sendEmailToken);

router.post('/verify-token', EmailController.verifyToken);

export default router;