# Create: Gregified Storage

**Create: Gregified Storage** (mod ID: `create_gs`) adds GregTech-style item vaults to the Create mod, powered by GTCEu. Store enormous quantities of items in compact, tiered storage blocks that scale with multiblock configurations.

---

## Features

- **Seven Vault Tiers**: Copper (27 slots), Bronze (54), Steel (72), Aluminium (90), Stainless Steel (108), Titanium (126), Tungstensteel (144).  
- **Multiblock Stacking**: Increase capacity via 2×2, 3×3 layers (multipliers 2–6×).  
- **Ponder Integration**: In‑game tutorial scene explains tiers, capacities, and stacking (press **W** on any vault item).

---

## Installation

1. **Forge**: Minecraft 1.20.1, Forge 47.1.43 or later.  
2. **Dependencies**:  
   - Create 1.20.1-6.0.0 or later.  
   - GTCEu 1.20.1-1.6.0 or later.   
3. **Drop** `create_gs-<version>.jar` into your `mods/` folder.  
4. Launch Minecraft.

---

## Usage

- Place a vault block from your inventory.  
- Vaults cannot be opened directly; interact with Create contraptions (belts, funnels, chutes).  
- Stack vaults in 2×2 or 3×3 arrays to multiply total storage capacity (see Ponder tutorial).

---

## Ponder Tutorial

Press **W** (default Ponder key) while hovering over a vault in Creative or in‑hand. The scene `vaults/capacity_demo` will play, cycling through each tier with capacity and stacking info.

---

## Configuration

This mod adds a server-side configuration file for vault capacities. It can be accessed at `<your-world-folder>/serverconfig/create_gs-server.toml`. You can also change the default config for every world at `<your-minecraft-folder>/defaultconfigs/create_gs-server.toml`.

---

## Contributing

1. Fork the repository.  
2. Create your feature branch: `git checkout -b feature/MyFeature`.  
3. Commit your changes: `git commit -am 'Add MyFeature'`.  
4. Push to the branch: `git push origin feature/MyFeature`.  
5. Open a Pull Request.

Please follow the code style and include tests for new functionality.

---

## License

This project is licensed under the MIT License – see [LICENSE](./LICENSE).

---

## Credits

> • **Create** – To the Create mod team, for their innovative mechanics and ongoing support.  
> • **GTCEu** – To the GregTech Community, for building and maintaining the GTCEu framework.  
> • **Lopyluna** – For the original Create: Bigger Storages mod, which inspired and provided the groundwork for this project.

## Links

- GitHub: https://github.com/susdw/Create-Gregified-Storage  
- Issues: https://github.com/susdw/Create-Gregified-Storage/issues