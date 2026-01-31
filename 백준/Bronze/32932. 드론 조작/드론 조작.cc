#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <climits>


bool arr[1001][1001] = { 0, };


void solve() {

	int n, m;
	std::cin >> n >> m;

	for (int i = 0; i < n; ++i) {
		int x, y;
		std::cin >> x >> y;
		arr[x + 500][y + 500] = 1;
	}

	int sx = 0, sy = 0;

	std::cin.ignore();
	std::string commands;
	std::getline(std::cin, commands);
	for (char command : commands) {
		if (command == 'U' && !arr[sx + 500][sy + 500 + 1]) {
			sy++;
		} else if (command == 'D' && !arr[sx + 500][sy + 500 - 1]) {
			sy--;
		} else if (command == 'L' && !arr[sx + 500 - 1][sy + 500]) {
			sx--;
		} else if (command == 'R' && !arr[sx + 500 + 1][sy + 500]) {
			sx++;
		}
	}

	std::cout << sx << ' ' << sy << '\n';

}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}