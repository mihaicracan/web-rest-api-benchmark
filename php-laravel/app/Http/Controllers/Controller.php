<?php

namespace App\Http\Controllers;

use Illuminate\Routing\Controller as BaseController;
use App\User;
use App\Country;

class Controller extends BaseController
{
    public function index() 
    {
    	return response()->json(['hello' => 'world']);
    }

    public function compute()
    {
    	$x = 0; $y = 1; $sum = 0;

    	for ($i = 0; $i <= 1000000; $i++)
    	{
    	    $z = $x + $y;
    	    $x = $y;
    	    $y = $z;

    	    $sum += $z;
    	}

    	return response()->json(['status' => 'done']);
    }

    public function countries()
    {
    	$data = Country::all();

    	return response()->json(['data' => $data]);
    }

    public function users()
    {
    	$data = User::whereHas('countries', function($query) {
    					$query->where('name', 'France');
    				})
    				->has('countries', '>=', 5)
    				->withCount('countries')
    				->get();

    	return response()->json(['data' => $data]);
    }
}
