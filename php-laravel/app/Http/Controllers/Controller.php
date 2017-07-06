<?php

namespace App\Http\Controllers;

use Illuminate\Routing\Controller as BaseController;
use App\User;
use App\Country;

class Controller extends BaseController
{
    public function hello() 
    {
    	return response()->json(['hello' => 'world']);
    }

    public function compute()
    {
    	$x = 0; $y = 1;

        $max = 10000 + rand(0, 500);

    	for ($i = 0; $i <= $max; $i++) {
    	    $z = $x + $y;
    	    $x = $y;
    	    $y = $z;
    	}

    	return response()->json(['status' => 'done']);
    }

    public function countries()
    {
    	$data = Country::all();

    	return response()->json($data);
    }

    public function users()
    {
    	$data = User::whereHas('countries', function($query) {
    					$query->where('name', 'France');
    				})
    				->with('countries')
    				->get();

    	return response()->json($data);
    }
}
