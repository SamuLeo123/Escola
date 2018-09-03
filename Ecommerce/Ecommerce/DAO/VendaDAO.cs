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

        public Venda BuscarVenda(int CPF, int IdFunc)
        {
            return context.Vendas.LastOrDefault(v => v.ClienteId == CPF && v.FuncionarioId == IdFunc);
        }

        public Venda Buscar(int IdFunc)
        {
            return context.Vendas.FirstOrDefault(v => v.FuncionarioId == IdFunc);
        }

        public IList<Venda> Listar()
        {
            return context.Vendas.ToList();
        }

        public IList<Venda> Listar(int IdFunc)
        {
            return context.Vendas.Where(v => v.FuncionarioId == IdFunc).ToList();
        }
    }
}