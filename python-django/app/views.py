from django.http import JsonResponse
from models import Country, User, UserSerializer, CountrySerializer


def index(req):
	return JsonResponse({ 'hello': 'world' })


def compute(req):
	x = 0
	y = 1

	for i in range(1000000):
		z = x + y
		x = y
		y = z

	return JsonResponse({ 'status': 'done' })


def countries(req):
	data = Country.objects.all()
	data = CountrySerializer(data, many=True).data

	return JsonResponse({ 'data': list(data) })


def users(req):
	data = User.objects.filter(usercountrymapping__countries__name='France').all()
	data = UserSerializer(data, many=True).data

	return JsonResponse({ 'data': list(data) })