import { Router } from 'express';
import { UserController } from '../controller/users-controller.js';
import { verifyToken } from '../utils/middleware/verify-token-middleware.js';

const router = Router();

router.post('/verify-user', verifyToken, UserController.verifyUser);

router.post('/reset-session', verifyToken, UserController.resetSession);

export default router;