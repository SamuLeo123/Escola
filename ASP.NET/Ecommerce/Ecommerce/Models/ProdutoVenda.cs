using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Ecommerce.Models
{
    public class ProdutoVenda
    {
        public int Id { get; set; }
        public double Quantidade { get; set; }
        public virtual Venda Vendas { get; set; }
        public int VendaId { get; set; }
        public virtual Produto Produtos { get; set; }
        public int ProdutoId { get; set; }
    }
}