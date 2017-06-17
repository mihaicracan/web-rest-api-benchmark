const bookshelf = require('../../bookshelf');
const Model = bookshelf.Model;

class Country extends Model
{
	get tableName() {
		return 'Country';
	}

	users() {
		return this.belongsToMany('User', 'UserCountryMapping', 'countryId', 'userId');
	}
}

module.exports = bookshelf.model('Country', Country);