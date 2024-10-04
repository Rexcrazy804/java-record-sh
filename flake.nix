{
  description = "A Nix-flake-based Java development environment";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable";
    flake-parts = {
      url = "github:hercules-ci/flake-parts";
      inputs.nixpkgs-lib.follows = "nixpkgs";
    };
  };

  outputs = {flake-parts, ...} @ inputs:
    flake-parts.lib.mkFlake {inherit inputs;} {
      imports = [
        # inputs.treefmt.flakeModule
      ];

      flake = {
        # original stuff? idk what this does just yet
      };

      systems = [
        "x86_64-linux"
        "aarch64-linux"
      ];

      perSystem = 
        {
          pkgs,
          system,
          ...
        }: let
          tex = (pkgs.texlive.combine {
            inherit (pkgs.texlive) scheme-basic;
            inherit (pkgs.texlivePackages) 
              minted 
              subfiles 
              fancyvrb 
              upquote 
              arara 
              caption
              pdfpages
              pdflscape
            ;
          });
        in {
          # treefmt = {
          #   projectRootFile = "./.git/config";
          #   programs = {
          #     alejandra.enable = true;
          #   };
          # };

          devShells.default = pkgs.mkShell {
            buildInputs = [
              pkgs.python312Packages.pygments
            ];

            packages = [
              tex
            ];
          };
        };
    };
}
