const express = require('express');
const controller = require('./app/Controllers/Controller')
const app = express();

app.listen(3000, () => {
  	console.log('listening on 3000')
})

app.get('/', controller.index);
app.get('/compute', controller.compute);
app.get('/countries', controller.countries);
app.get('/users', controller.users);