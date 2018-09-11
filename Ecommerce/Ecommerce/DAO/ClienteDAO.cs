using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Ecommerce.Models;

namespace Ecommerce.DAO
{
    public class ClienteDAO
    {
        private EntityContext context;
        public ClienteDAO()
        {
            context = new EntityContext();
        }

        public IList<Cliente> ListarClientes()
        {
            return context.Clientes.ToList();
        }

        public Cliente BuscarCliCPF(int cpf)
        {
            return context.Clientes.FirstOrDefault(c => c.Id == cpf);
        }

        public IList<Cliente> BuscarClisCPF(int cpf)
        {
            return context.Clientes.Where(c => c.CPF == cpf).ToList();
        }

        public void Atualizar()
        {
            context.SaveChanges();
        }

        public void Cadastrar(Cliente c)
        {
            context.Clientes.Add(c);
            Atualizar();
        }

        public void Remover(Cliente c)
        {
            context.Clientes.Remove(c);
            Atualizar();
        }
    }
}