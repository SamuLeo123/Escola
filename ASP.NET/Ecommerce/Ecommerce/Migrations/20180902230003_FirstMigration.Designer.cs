using System;
using Microsoft.Data.Entity;
using Microsoft.Data.Entity.Infrastructure;
using Microsoft.Data.Entity.Metadata;
using Microsoft.Data.Entity.Migrations;
using Ecommerce.Models;

namespace Ecommerce.Migrations
{
    [DbContext(typeof(EntityContext))]
    [Migration("20180902230003_FirstMigration")]
    partial class FirstMigration
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
            modelBuilder
                .HasAnnotation("ProductVersion", "7.0.0-rc1-16348")
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("Ecommerce.Models.Cliente", b =>
                {
                    b.Property<int>("CPF")
                        .ValueGeneratedOnAdd();

                    b.Property<DateTime>("DataCriacao");

                    b.Property<string>("Email")
                        .IsRequired();

                    b.Property<string>("Endereco")
                        .IsRequired();

                    b.Property<string>("Nome")
                        .IsRequired();

                    b.Property<string>("NumTel")
                        .IsRequired();

                    b.HasKey("CPF");
                });

            modelBuilder.Entity("Ecommerce.Models.Funcionario", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<DateTime>("DataCriacao");

                    b.Property<string>("Email")
                        .IsRequired()
                        .HasAnnotation("MaxLength", 100);

                    b.Property<string>("Endereco")
                        .IsRequired()
                        .HasAnnotation("MaxLength", 100);

                    b.Property<string>("Login")
                        .IsRequired()
                        .HasAnnotation("MaxLength", 25);

                    b.Property<string>("Nome")
                        .IsRequired()
                        .HasAnnotation("MaxLength", 100);

                    b.Property<string>("NumTel")
                        .IsRequired()
                        .HasAnnotation("MaxLength", 15);

                    b.Property<string>("Senha")
                        .IsRequired()
                        .HasAnnotation("MaxLength", 25);

                    b.HasKey("Id");
                });

            modelBuilder.Entity("Ecommerce.Models.Produto", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("Descricao")
                        .IsRequired()
                        .HasAnnotation("MaxLength", 100);

                    b.Property<string>("Fabricante")
                        .IsRequired()
                        .HasAnnotation("MaxLength", 100);

                    b.Property<string>("Nome")
                        .IsRequired()
                        .HasAnnotation("MaxLength", 50);

                    b.Property<double>("Preco");

                    b.Property<int>("Quantidade");

                    b.HasKey("Id");
                });

            modelBuilder.Entity("Ecommerce.Models.ProdutoVenda", b =>
                {
                    b.Property<int>("ProdutoId");

                    b.Property<int>("VendaId");

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
