// fake-api.js
const express = require('express');
const app = express();
const PORT = 3001;

const employees = {
  'E002': { code: 'E002', name: 'Bob Smith', position: 'Frontend Developer' },
  'E003': { code: 'E003', name: 'Carlos Méndez', position: 'DevOps Engineer' }
};

app.get('/employees/:code', (req, res) => {
  const emp = employees[req.params.code];
  if (emp) res.json(emp);
  else res.status(404).json({ error: 'Not found' });
});

app.listen(PORT, () => {
  console.log(`Fake API running at http://localhost:${PORT}`);
});
