using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using dotnet_core.Models;

namespace dotnet_core.Data
{
    public class ApplicationDbContext : DbContext
    {
        public virtual DbSet<User> User { get; set; }
        public virtual DbSet<Country> Country { get; set; }
        public virtual DbSet<UserCountryMapping> UserCountryMapping { get; set; }

        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }

        protected override void OnModelCreating(ModelBuilder builder)
        {
            builder.Entity<UserCountryMapping>()
                .HasKey(uc => new { uc.userId, uc.countryId });

            builder.Entity<UserCountryMapping>()
                .HasOne(uc => uc.user)
                .WithMany(u => u.userCountryMappings)
                .HasForeignKey(uc => uc.userId);

            builder.Entity<UserCountryMapping>()
                .HasOne(uc => uc.country)
                .WithMany(c => c.userCountryMappings)
                .HasForeignKey(uc => uc.countryId);
        }
    }
}