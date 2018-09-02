using System;
using System.Collections.Generic;
using Microsoft.Data.Entity.Migrations;

namespace Ecommerce.Migrations
{
    public partial class LoginFunc : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(name: "FK_ProdutoVenda_Produto_ProdutoId", table: "ProdutoVenda");
            migrationBuilder.DropForeignKey(name: "FK_ProdutoVenda_Venda_VendaId", table: "ProdutoVenda");
            migrationBuilder.DropForeignKey(name: "FK_Venda_Cliente_ClienteId", table: "Venda");
            migrationBuilder.DropForeignKey(name: "FK_Venda_Funcionario_FuncionarioId", table: "Venda");
            migrationBuilder.AlterColumn<string>(
                name: "Nome",
                table: "Produto",
                nullable: false);
            migrationBuilder.AlterColumn<string>(
                name: "Fabricante",
                table: "Produto",
                nullable: false);
            migrationBuilder.AlterColumn<string>(
                name: "Descricao",
                table: "Produto",
                nullable: false);
            migrationBuilder.AddColumn<string>(
                name: "Login",
                table: "Funcionario",
                nullable: true);
            migrationBuilder.AddForeignKey(
                name: "FK_ProdutoVenda_Produto_ProdutoId",
                table: "ProdutoVenda",
                column: "ProdutoId",
                principalTable: "Produto",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
            migrationBuilder.AddForeignKey(
                name: "FK_ProdutoVenda_Venda_VendaId",
                table: "ProdutoVenda",
                column: "VendaId",
                principalTable: "Venda",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
            migrationBuilder.AddForeignKey(
                name: "FK_Venda_Cliente_ClienteId",
                table: "Venda",
                column: "ClienteId",
                principalTable: "Cliente",
                principalColumn: "CPF",
                onDelete: ReferentialAction.Cascade);
            migrationBuilder.AddForeignKey(
                name: "FK_Venda_Funcionario_FuncionarioId",
                table: "Venda",
                column: "FuncionarioId",
                principalTable: "Funcionario",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(name: "FK_ProdutoVenda_Produto_ProdutoId", table: "ProdutoVenda");
            migrationBuilder.DropForeignKey(name: "FK_ProdutoVenda_Venda_VendaId", table: "ProdutoVenda");
            migrationBuilder.DropForeignKey(name: "FK_Venda_Cliente_ClienteId", table: "Venda");
            migrationBuilder.DropForeignKey(name: "FK_Venda_Funcionario_FuncionarioId", table: "Venda");
            migrationBuilder.DropColumn(name: "Login", table: "Funcionario");
            migrationBuilder.AlterColumn<string>(
                name: "Nome",
                table: "Produto",
                nullable: true);
            migrationBuilder.AlterColumn<string>(
                name: "Fabricante",
                table: "Produto",
                nullable: true);
            migrationBuilder.AlterColumn<string>(
                name: "Descricao",
                table: "Produto",
                nullable: true);
            migrationBuilder.AddForeignKey(
                name: "FK_ProdutoVenda_Produto_ProdutoId",
                table: "ProdutoVenda",
                column: "ProdutoId",
                principalTable: "Produto",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
            migrationBuilder.AddForeignKey(
                name: "FK_ProdutoVenda_Venda_VendaId",
                table: "ProdutoVenda",
                column: "VendaId",
                principalTable: "Venda",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
            migrationBuilder.AddForeignKey(
                name: "FK_Venda_Cliente_ClienteId",
                table: "Venda",
                column: "ClienteId",
                principalTable: "Cliente",
                principalColumn: "CPF",
                onDelete: ReferentialAction.Restrict);
            migrationBuilder.AddForeignKey(
                name: "FK_Venda_Funcionario_FuncionarioId",
                table: "Venda",
                column: "FuncionarioId",
                principalTable: "Funcionario",
                principalColumn: "Id",
                onDelete: ReferentialAction.Restrict);
        }
    }
}
