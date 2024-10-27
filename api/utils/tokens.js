
const getToken = () => {
  return Math.random().toString(36).slice(-5);
}

const methods = {
  getToken
};

export default methods;
