const bookshelf = require('../../bookshelf');
const Model = bookshelf.Model;

class User extends Model
{
	get tableName() {
		return 'User';
	}

	countries() {
		return this.belongsToMany('Country', 'UserCountryMapping', 'userId', 'countryId');
	}
}

module.exports = bookshelf.model('User', User);