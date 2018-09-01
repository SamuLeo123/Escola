using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Ecommerce.Models;

namespace Ecommerce.DAO
{
    public class ProdutoDAO
    {
        private EntityContext context;

        public ProdutoDAO()
        {
            context = new EntityContext();
        }

        public IList<Produto> ProdutoToList()
        {
            return context.Produtos.ToList();
        }

        public Produto BuscarPorId(int id)
        {
            return context.Produtos.FirstOrDefault(u => u.Id == id);
        }

        public void Adicionar(Produto p) {
            context.Produtos.Add(p);
            Atualizar();
        }

        public void Atualizar() {
            context.SaveChanges();
        }

        public void Remover(Produto p)
        {
            context.Produtos.Remove(p);
            Atualizar();
        }
    }
}