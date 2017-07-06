using System;
using System.Collections.Generic;

namespace dotnet_core.Models
{
    public partial class UserCountryMapping
    {
        public int id { get; set; }
        public int userId { get; set; }
        public int countryId { get; set; }
        public User user { get; set; }
        public Country country { get; set; }
    }
}