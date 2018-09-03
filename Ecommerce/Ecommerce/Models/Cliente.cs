using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Ecommerce.Models
{
    public class Cliente
    {
        public int Id{ get; set; }
        [Required]
        public int CPF { get; set; }
        [Required]
        public string Nome { get; set; }
        [Required]
        public string Endereco { get; set; }
        [Required]
        public string NumTel { get; set; }
        [Required]
        public string Email { get; set; }
        public DateTime DataCriacao { get; set; }
    }
}