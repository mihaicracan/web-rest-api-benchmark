using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using dotnet_core.Models;
using dotnet_core.Data;

namespace dotnet_core.Controllers
{
    public class MyController : Controller
    {
        private readonly ApplicationDbContext context;

        public MyController(ApplicationDbContext context)
        {
            this.context = context;
        } 

        [HttpGet]
        [Route("/")]
        public IEnumerable<string> hello()
        {
            return new string[] { "hello", "world" };
        }

        [HttpGet]
        [Route("/compute")]
        public IEnumerable<string> compute()
        {
            int x = 0, y = 1, z, max;

            Random r = new Random();
            max = 10000 + r.Next(500);

            for (int i = 0; i <= max; i++) {
                z = x + y;
                x = y;
                y = z;
            }

            return new string[] { "status", "done" };
        }

        [HttpGet]
        [Route("/countries")]
        public IEnumerable<Country> countries()
        {
            return context.Country.ToList();
        }

        [HttpGet]
        [Route("/users")]
        public object users()
        {
            return context.UserCountryMapping
                    .Where(uc => uc.country.name.Equals("France"))
                    .Select(uc => new {
                        id = uc.user.id,
                        firstName = uc.user.firstName,
                        lastName = uc.user.lastName,
                        email = uc.user.email,
                        countries = uc.user.userCountryMappings.Select(m => m.country)
                    })
                    .ToList();
        }
    }
}
