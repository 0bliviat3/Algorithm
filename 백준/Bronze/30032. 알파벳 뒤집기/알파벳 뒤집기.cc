#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <algorithm>
#include <cmath>


char lotate(char c, int d) {
	if (d == 1) {
		if (c == 'd') return 'q';
		else if (c == 'q') return 'd';
		else if (c == 'b') return 'p';
		else if (c == 'p') return 'b';
		else return c;
	} else {
		if (c == 'd') return 'b';
		else if (c == 'p') return 'q';
		else if (c == 'b') return 'd';
		else if (c == 'q') return 'p';
		else return c;
	}
	
}

void solve() {
	int n, d;
	std::cin >> n >> d;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			char c;
			std::cin >> c;
			std::cout << lotate(c, d);
		}
		std::cout << "\n";
	}
}

int main() {
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	solve();
	return 0;
}