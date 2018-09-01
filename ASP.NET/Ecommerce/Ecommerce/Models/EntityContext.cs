using Microsoft.Data.Entity;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;

namespace Ecommerce.Models
{
    public class EntityContext : DbContext
    {
        public DbSet<Produto> Produtos { get; set; }
        public DbSet<Cliente> Clientes { get; set; }
        public DbSet<Funcionario> Funcionarios { get; set; }
        public DbSet<Venda> Vendas { get; set; }
        public DbSet<ProdutoVenda> ProdutoVenda { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            string conexao = ConfigurationManager.ConnectionStrings["connString"].ConnectionString;
            optionsBuilder.UseSqlServer(conexao);
            base.OnConfiguring(optionsBuilder);
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<ProdutoVenda>().HasKey(iv => new { iv.ProdutoId, iv.VendaId });
            modelBuilder.Entity<Cliente>().HasKey(id => new { id.CPF });
            base.OnModelCreating(modelBuilder);
        }
    }
}