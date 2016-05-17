using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dominio;

namespace Repositorio.EF
{
    class ContextoDeDados : DbContext
    {
        public ContextoDeDados() : base("ExemploADODotNet")
        {

        }

        public DbSet<Usuario> Usuario { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);
        }
    }
}
