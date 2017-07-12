<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Country extends Model
{
    protected $table = 'Country';

    public function users()
    {
        return $this->belongsToMany('App\User', 'UserCountryMapping', 'countryId', 'userId');
    }
}
