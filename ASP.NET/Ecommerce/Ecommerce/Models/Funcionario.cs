using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Ecommerce.Models
{
    public class Funcionario
    {
        public int Id { get; set; }
        [Required, StringLength(100)]
        public string Nome { get; set; }
        [Required, StringLength(25)]
        public string Login { get; set; }
        [Required, StringLength(25)]
        public string Senha { get; set; }
        [Required, StringLength(100)]
        public string Endereco { get; set; }
        [Required, StringLength(15)]
        public string NumTel { get; set; }
        [Required, StringLength(100)]
        public string Email { get; set; }
        public DateTime DataCriacao { get; set; }
    }
}