from django.db import models
from rest_framework import serializers


class Country(models.Model):
	name = models.CharField(max_length=50)

	class Meta:
		db_table = 'Country'

class User(models.Model):
	firstName = models.CharField(max_length=50)
	lastName = models.CharField(max_length=50)
	email = models.CharField(max_length=100)
	countries = models.ManyToManyField(Country, through='UserCountryMapping')

	class Meta:
		db_table = 'User'


class UserCountryMapping(models.Model):    

    users = models.ForeignKey(User, db_column='userId')
    countries = models.ForeignKey(Country, db_column='countryId')

    class Meta:
        db_table = 'UserCountryMapping'


class UserSerializer(serializers.ModelSerializer):

    class Meta:
        model = User
        fields = ('id', 'firstName', 'lastName', 'email', 'countries')
        depth = 1


class CountrySerializer(serializers.ModelSerializer):

    class Meta:
        model = Country
        fields = ('id', 'name')