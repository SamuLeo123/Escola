using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Ecommerce.Models;

namespace Ecommerce.DAO
{
    public class VendaDAO
    {
        private EntityContext context;

        public VendaDAO()
        {
            context = new EntityContext();
        }

        public void Cadastrar(Venda v)
        {
            context.Vendas.Add(v);
            context.SaveChanges();
        }

        public void Atualizar()
        {
            context.SaveChanges();
        }

        public Venda BuscarPorId(int id) {
            return context.Vendas.FirstOrDefault(u => u.Id == id);
        }

        public IList<Venda> Listar()
        {
            return context.Vendas.ToList();
        }
    }
}