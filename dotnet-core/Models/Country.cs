using System;
using System.Collections.Generic;

namespace dotnet_core.Models
{
    public partial class Country
    {
        public int id { get; set; }
        public string name { get; set; }
        public ICollection<UserCountryMapping> userCountryMappings { get; set; }
    }
}