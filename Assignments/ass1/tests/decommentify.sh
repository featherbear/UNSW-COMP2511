#/bin/sh

# Remove comment lines from *.commented.json

cd "$(dirname "$0")"

# shopt -s nullglob
for f in *.commented.json
do
  base="${f%%.*}"
  echo Stripping comments from $f into $base.json
  sed '/^#/ d' < $f > $base.json
done
