const config = require('./config.js');
const knex = require('knex')(config.db);
const bookshelf = require('bookshelf')(knex);

bookshelf.plugin('registry');

module.exports = bookshelf;