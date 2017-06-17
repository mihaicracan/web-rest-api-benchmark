<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class User extends Model
{
    protected $table = 'User';

    public function countries()
    {
        return $this->belongsToMany('App\Country', 'UserCountryMapping', 'userId', 'countryId');
    }
}
