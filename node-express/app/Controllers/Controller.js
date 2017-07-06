const Country = require('../Models/Country');
const User = require('../Models/User');

class Controller 
{
	hello(req, res) {
		return res.json({ hello: 'world' });
	}

	compute(req, res) {
		let x = 0, y = 1;

		let max = 1000000 + Math.random() * 50000;

		for (let i = 0; i <= max; i++) {
		    let z = x + y;
		    x = y;
		    y = z;
		}

		return res.json({ status: 'done' })
	}

	async countries(req, res) {
		let data = await Country.fetchAll();

		return res.json({ data });
	}

	async users(req, res) {
		let data = await User.query(q => {
				q.innerJoin('UserCountryMapping', 'User.id', 'UserCountryMapping.userId');
				q.innerJoin('Country', 'UserCountryMapping.countryId', 'Country.id');
				q.groupBy('User.id');
				q.where('Country.name', 'France');
			})
			.fetchAll({
			 	withRelated: ['countries']
			})

		return res.json({ data });
	}
}

module.exports = new Controller();