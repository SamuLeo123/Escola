using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Ecommerce.Models;

namespace Ecommerce.DAO
{
    public class FuncionarioDAO
    {
        private EntityContext context;
        public FuncionarioDAO()
        {
            context = new EntityContext();
        }

        public IList<Funcionario> ListarFuncionarios()
        {
            return context.Funcionarios.ToList();
        }

        public Funcionario BuscarFuncId(int id)
        {
            return context.Funcionarios.FirstOrDefault(f => f.Id == id);
        }

        public void Atualizar()
        {
            context.SaveChanges();
        }

        public void Cadastrar(Funcionario f)
        {
            context.Funcionarios.Add(f);
            Atualizar();
        }

        public void Remover(Funcionario f)
        {
            context.Funcionarios.Remove(f);
            Atualizar();
        }

        public Funcionario Login(Funcionario func)
        {
            try
            {
                Funcionario funcionario = context.Funcionarios.FirstOrDefault(f => f.Login == func.Login && f.Senha == func.Senha);
                if (funcionario == null)
                {
                    return funcionario;
                }
                else
                {
                    return funcionario;
                }
            }          
            catch (Exception)
            {
                Funcionario f = new Funcionario();
                return f;
            }
        }
    }
}