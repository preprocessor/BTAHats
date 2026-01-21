import json
from pathlib import Path

# Directory of this script: models/entity
script_dir = Path(__file__).resolve().parent

# Parent directory: models
models_dir = script_dir.parent

# Find .geo.json files in the parent directory
geo_files = [
    f"/assets/sillylittlehats/models/{path.name}"
    for path in models_dir.iterdir()
    if path.is_file() and path.suffixes == [".geo", ".json"]
]

# Output file in the same directory as the script
output_path = script_dir / "models.json"

# Write models.json
with output_path.open("w", encoding="utf-8") as f:
    json.dump(
        {"model_paths": geo_files},
        f,
        indent=2
    )

print(f"Wrote {len(geo_files)} model paths to {output_path}")
