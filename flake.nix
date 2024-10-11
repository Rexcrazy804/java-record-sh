{
  description = "A Nix-flake-based Java development environment";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/nixos-unstable";
    flake-parts = {
      url = "github:hercules-ci/flake-parts";
      inputs.nixpkgs-lib.follows = "nixpkgs";
    };

    git-hooks-nix = {
      url = "github:cachix/git-hooks.nix";
      inputs.nixpkgs.follows = "nixpkgs";
    };
  };

  outputs = {flake-parts, ...} @ inputs:
    flake-parts.lib.mkFlake {inherit inputs;} {
      imports = [
        inputs.git-hooks-nix.flakeModule
      ];

      flake = {
        # original stuff? idk what this does just yet
      };

      systems = [
        "x86_64-linux"
        "aarch64-linux"
      ];

      perSystem = {
        pkgs,
        system,
        config,
        ...
      }: {
        pre-commit = {
          check.enable = true;
          settings.hooks = {
            goole-java-format = {
              enable = true;
              name = "google-java-format";
              description = "Run the google java formatter";
              files = "\\.java$";
              extraPackages = [pkgs.google-java-format];
              entry = "google-java-format --set-exit-if-changed --replace";
            };

            alejandra.enable = true;
            latexindent.enable = true;
          };
        };
        devShells.default = pkgs.mkShell {
          shellHook = ''
            ${config.pre-commit.installationScript}
          '';
          buildInputs = [
            pkgs.python312Packages.pygments
            config.pre-commit.settings.enabledPackages
          ];

          packages = let
            tex = pkgs.texlive.combine {
              inherit (pkgs.texlive) scheme-basic;
              inherit
                (pkgs.texlivePackages)
                minted
                subfiles
                fancyvrb
                upquote
                arara
                caption
                pdfpages
                pdflscape
                ;
            };
          in [tex];
        };
      };
    };
}
