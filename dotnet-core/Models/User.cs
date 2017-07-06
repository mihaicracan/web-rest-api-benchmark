using System;
using System.Collections.Generic;

namespace dotnet_core.Models
{
    public partial class User
    {
        public int id { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
        public string email { get; set; }
        public ICollection<UserCountryMapping> userCountryMappings { get; set; }
    }
}