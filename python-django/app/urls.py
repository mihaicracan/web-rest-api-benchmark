from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^hello', views.hello),
    url(r'^compute', views.compute),
    url(r'^countries', views.countries),
    url(r'^users', views.users),
]
