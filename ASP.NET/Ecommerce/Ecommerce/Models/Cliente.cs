using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace Ecommerce.Models
{
    public class Cliente
    {
        [Key]
        public int CPF { get; set; }
        public string Nome { get; set; }
        public string Endereco { get; set; }
        public string NumTel { get; set; }
        public string Email { get; set; }
        public DateTime DataCriacao { get; set; }
    }
}