using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Ecommerce.Models;

namespace Ecommerce.DAO
{
    public class ProdutoVendaDAO
    {
        public static List<ProdutoVenda> Carrinho = new List<ProdutoVenda>();

        private EntityContext context;
        public ProdutoVendaDAO()
        {
            context = new EntityContext();
        }

        public IList<ProdutoVenda> Listar()
        {
            return context.ProdutoVenda.ToList();
        }

        public ProdutoVenda BuscarPorId(int id)
        {
            return context.ProdutoVenda.FirstOrDefault(pv => pv.Id == id);
        }

        public void Atualizar()
        {
            context.SaveChanges();
        }

        public void Cadastrar(ProdutoVenda pv)
        {
            context.ProdutoVenda.Add(pv);
            Atualizar();
        }

        public void Remover(ProdutoVenda pv)
        {
            context.ProdutoVenda.Remove(pv);
            Atualizar();
        }
    }
}