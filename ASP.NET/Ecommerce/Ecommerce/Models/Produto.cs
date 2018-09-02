using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace Ecommerce.Models
{
    public class Produto
    {
        public int Id { get; set; }
        [Required, StringLength(50)]
        public string Nome { get; set; }
        [Required, StringLength(100)]
        public string Descricao { get; set; }
        [Required, Range(0.01, 10000)]
        public double Preco { get; set; }
        [Required, Range(1, 10000)]
        public int Quantidade { get; set; }
        [Required, StringLength(100)]
        public string Fabricante { get; set; }
    }
}