using System;
using Microsoft.Data.Entity;
using Microsoft.Data.Entity.Infrastructure;
using Microsoft.Data.Entity.Metadata;
using Microsoft.Data.Entity.Migrations;
using Ecommerce.Models;

namespace Ecommerce.Migrations
{
    [DbContext(typeof(EntityContext))]
    partial class EntidadesContextModelSnapshot : ModelSnapshot
    {
        protected override void BuildModel(ModelBuilder modelBuilder)
        {
            modelBuilder
                .HasAnnotation("ProductVersion", "7.0.0-rc1-16348")
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("Ecommerce.Models.Cliente", b =>
                {
                    b.Property<int>("CPF")
                        .ValueGeneratedOnAdd();

                    b.Property<DateTime>("DataCriacao");

                    b.Property<string>("Email");

                    b.Property<string>("Endereco");

                    b.Property<string>("Nome");

                    b.Property<string>("NumTel");

                    b.HasKey("CPF");
                });

            modelBuilder.Entity("Ecommerce.Models.Funcionario", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<DateTime>("DataCriacao");

                    b.Property<string>("Email");

                    b.Property<string>("Endereco");

                    b.Property<string>("Nome");

                    b.Property<string>("NumTel");

                    b.Property<string>("Senha");

                    b.HasKey("Id");
                });

            modelBuilder.Entity("Ecommerce.Models.Produto", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("Descricao");

                    b.Property<string>("Fabricante");

                    b.Property<string>("Nome");

                    b.Property<double>("Preco");

                    b.Property<int>("Quantidade");

                    b.HasKey("Id");
                });

            modelBuilder.Entity("Ecommerce.Models.ProdutoVenda", b =>
                {
                    b.Property<int>("ProdutoId");

                    b.Property<int>("VendaId");

                    b.Property<int>("Id");

                    b.Property<double>("Quantidade");

                    b.HasKey("ProdutoId", "VendaId");
                });

            modelBuilder.Entity("Ecommerce.Models.Venda", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<int>("ClienteId");

                    b.Property<DateTime>("Data");

                    b.Property<int>("FuncionarioId");

                    b.Property<double>("PrecoTotal");

                    b.HasKey("Id");
                });

            modelBuilder.Entity("Ecommerce.Models.ProdutoVenda", b =>
                {
                    b.HasOne("Ecommerce.Models.Produto")
                        .WithMany()
                        .HasForeignKey("ProdutoId");

                    b.HasOne("Ecommerce.Models.Venda")
                        .WithMany()
                        .HasForeignKey("VendaId");
                });

            modelBuilder.Entity("Ecommerce.Models.Venda", b =>
                {
                    b.HasOne("Ecommerce.Models.Cliente")
                        .WithMany()
                        .HasForeignKey("ClienteId");

                    b.HasOne("Ecommerce.Models.Funcionario")
                        .WithMany()
                        .HasForeignKey("FuncionarioId");
                });
        }
    }
}
