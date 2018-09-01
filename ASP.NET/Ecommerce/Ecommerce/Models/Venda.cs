using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Ecommerce.Models
{
    public class Venda
    {
        public int Id { get; set; }
        public double PrecoTotal { get; set; }
        public DateTime Data { get; set; }
        public virtual IList<ProdutoVenda> ItemProduto { get; set; }
        public virtual Cliente Clientes { get; set; }
        public int ClienteId { get; set; }
        public virtual Funcionario Funcionarios { get; set; }
        public int FuncionarioId { get; set; }
    }
}